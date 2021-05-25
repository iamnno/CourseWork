package com.example.CourseWork.web;

import com.example.CourseWork.model.Flat;
import com.example.CourseWork.model.FlatDescription;
import com.example.CourseWork.model.FlatParameter;
import com.example.CourseWork.model.User;
import com.example.CourseWork.service.FlatService;
import com.example.CourseWork.service.UserService;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;

@WebServlet(name = "FrontController", urlPatterns = {"/do/*"})
public class FrontControllerServlet extends HttpServlet {

    FlatService flatService;
    UserService userService;

    public void init(ServletConfig config) throws ServletException {
        flatService = (FlatService) config.getServletContext().getAttribute("flatService");
        userService = (UserService) config.getServletContext().getAttribute("userService");
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String pathInfo = request.getPathInfo();
        if (pathInfo == null) {
            pathInfo = "/";
        }
        try {
            switch (pathInfo) {
                case "/login":
                    login(request, response);
                    break;
                case "/register":
                    register(request, response);
                    break;
                case "/logout":
                    logout(request, response);
                    break;
                case "/main":
                    main(request, response);
                    break;
                case "/flat":
                    flat(request, response);
                    break;
                case "/flatedit":
                    flatedit(request, response);
                    break;
                case "/flatupdate":
                    flatupdate(request, response);
                    break;
                case "/flatnew":
                    flatnew(request, response);
                    break;
                case "/flatsave":
                    flatsave(request, response);
                    break;
                case "/flatdelete":
                    flatdelete(request, response);
                    break;
                case "/":
                case "/search":
                default:
                    main(request, response);
                    break;            }
        } catch (RuntimeException e) {
            error(request, response, "Oops, " + e.getMessage());}
    }

    protected void main(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String pf = request.getParameter("pf");
        String pt = request.getParameter("pt");
        String rf = request.getParameter("rf");
        String rt = request.getParameter("rt");
        String a = request.getParameter("a");
        String m = request.getParameter("m");


        HashMap<String, Object> parameters = flatService.searchParameter(pf,pt,rf,rt,a,m);
        Collection<Flat> flats = flatService.search(parameters);

        request.setAttribute("flats", flats);
        request.setAttribute("pf", pf);
        request.setAttribute("pt", pt);
        request.setAttribute("rf", rf);
        request.setAttribute("rt", rt);

        request.getRequestDispatcher("/WEB-INF/jsp/main.jsp").forward(request, response);
    }

    protected void flat(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int flatID = Integer.parseInt(request.getParameter("flatID"));
        Flat flat = flatService.getFlatbyID(flatID);
        request.setAttribute("flat", flat);
        request.getRequestDispatcher("/WEB-INF/jsp/flat.jsp").forward(request, response);
    }

    protected void flatedit(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int flatID = Integer.parseInt(request.getParameter("flatID"));
        Flat flat = flatService.getFlatbyID(flatID);
        request.setAttribute("flat", flat);
        request.getRequestDispatcher("/WEB-INF/jsp/flatedit.jsp?flatID=" + flatID).forward(request, response);
    }

    protected void flatnew(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getSession().getAttribute("user");
        request.getRequestDispatcher("/WEB-INF/jsp/flatnew.jsp").forward(request, response);
    }

    protected void flatupdate(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int flatID = Integer.parseInt(request.getParameter("flatID"));
        Flat flat = flatService.getFlatbyID(flatID);
        User user = (User) request.getSession().getAttribute("user");

        Boolean available = false;
        if (request.getParameter("flatavailable") != null) { available = true;}

        Boolean animal = false;
        if (request.getParameter("flatanimal") != null) { animal = true;}

        Boolean metro = false;
        if (request.getParameter("flatmetro") != null) { metro = true;}

        flat.getFlatP().setAnimal(animal);
        flat.getFlatP().setMetro(metro);
        flat.setAvailable(available);

        if (request.getParameter("flatrooms") != null) {
            flat.getFlatP().setRooms(Integer.parseInt(request.getParameter("flatrooms")));}

        if (request.getParameter("flatprice") != null) {
            flat.getFlatP().setPrice(Integer.parseInt(request.getParameter("flatprice")));}

        if (request.getParameter("flattitle") != null) {
            flat.getFlatD().setTitle(request.getParameter("flattitle"));}

        if (request.getParameter("flattext") != null) {
            flat.getFlatD().setText(request.getParameter("flattext"));}

        if (request.getParameter("flatcontact") != null) {
            flat.getFlatD().setContact(request.getParameter("flatcontact"));}

        flatService.updateFlat(flat);
        request.setAttribute("flat", flat);
        request.getRequestDispatcher("/WEB-INF/jsp/flat.jsp?flatID=" + flat.getFlatID()).forward(request, response);
    }

    protected void flatsave(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        User user = (User) request.getSession().getAttribute("user");

        Boolean available = false;
        if (request.getParameter("flatavailable") != null) { available = true;}

        Boolean animal = false;
        if (request.getParameter("flatanimal") != null) { animal = true;}

        Boolean metro = false;
        if (request.getParameter("flatmetro") != null) { metro = true;}

        Flat flat = new Flat(user.getUserID(),
                new FlatDescription(request.getParameter("flattitle"),
                        request.getParameter("flattext"),
                        user.getName(),
                        request.getParameter("flatcontact")),
                new FlatParameter(Integer.parseInt(request.getParameter("flatprice")),
                        Integer.parseInt(request.getParameter("flatrooms")),
                        animal,
                        metro),
                        available);

        flatService.newFlat(flat, user);
        request.setAttribute("flat", flat);
        request.getRequestDispatcher("/WEB-INF/jsp/flat.jsp?flatID=" + flat.getFlatID()).forward(request, response);
    }

    protected void flatdelete(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int flatID = Integer.parseInt(request.getParameter("flatID"));
        Flat flat = flatService.getFlatbyID(flatID);
        User user = (User) request.getSession().getAttribute("user");

        flatService.deleteFlat(flat, user);
        main(request, response);
    }

    protected void login(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getSession().invalidate();

        String login = request.getParameter("login");
        User user = userService.getByLogin(login);
        if (!userService.checkUser(login)) {
            error(request, response, "Вибачне, та користувач з логіном: "+ login +", не існує");
            return;}
        String password = request.getParameter("password");

        if (!userService.checkPass(user, password)) {
            error(request, response, "Вибачне, та пароль не правильний");
            return;}

        request.getSession().setAttribute("user", user);
        response.sendRedirect(".");
    }

    protected void register(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getSession().invalidate();

        String login = request.getParameter("login");
        if (userService.checkUser(login)) {
            error(request, response, "Вибачне, та користувач з логіном: "+ login +", вже існує");
            return;}
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        User user = new User(username, login, password);

        userService.newUser(user);

        request.getSession().setAttribute("user", user);
        response.sendRedirect(".");
    }

    protected void logout(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setAttribute("flats", flatService.getAllFlat());
        request.getSession().invalidate();
        response.sendRedirect(".");
    }

    protected void error(HttpServletRequest request, HttpServletResponse response, String message)
            throws ServletException, IOException {
        request.setAttribute("message", message);
        request.getRequestDispatcher("/WEB-INF/jsp/error.jsp").forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}