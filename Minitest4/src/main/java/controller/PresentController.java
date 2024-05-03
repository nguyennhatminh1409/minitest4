package controller;

import moduel.Present;
import service.PresentDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "presentServlet", urlPatterns = "/present")
public class PresentController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private PresentDAO presentDAO;

    public void init() {
        presentDAO = new PresentDAO();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null);{
            action = "";
        }
        switch (action) {
            case "create":
                showCreateForm(req, resp);
                break;
            case "edit":
                showEditForm(req, resp);
                break;
            case "delete":
                deletePresent(req, resp);
            default:
                listPresents(req, resp);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null);{
            action = "";
        }
        switch (action) {
            case "create":
                insertPresent(req, resp);
                break;
            case "edit":
                insertPresent(req, resp);
                break;
            default: {
                break;
            }
        }
    }

    private void deletePresent(HttpServletRequest req, HttpServletResponse resp) {
        List<Present> listPresent = presentDAO.selectAllPresent();
        int id = Integer.parseInt(req.getParameter("id"));
        try {
            presentDAO.deletePresent(id);
            req.setAttribute("listPresent", listPresent);
            RequestDispatcher dispatcher = req.getRequestDispatcher("present/list.jsp");
            dispatcher.forward(req, resp);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void listPresents(HttpServletRequest req, HttpServletResponse resp) {
        List<Present> listPresent = presentDAO.selectAllPresent();
        req.setAttribute("listPresent", listPresent);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("present/list.jsp");
        try {
            requestDispatcher.forward(req, resp);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void showEditForm(HttpServletRequest req, HttpServletResponse resp) {
        int id = Integer.parseInt(req.getParameter("id"));
        Present existingPresent = presentDAO.selectPresent(id);
        RequestDispatcher dispatcher = req.getRequestDispatcher("present/edit.jsp");
        req.setAttribute("present", existingPresent);
        try {
            dispatcher.forward(req, resp);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void showCreateForm(HttpServletRequest req, HttpServletResponse resp) {
        RequestDispatcher dispatcher = req.getRequestDispatcher("present/create.jsp");
        try {
            dispatcher.forward(req, resp);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void updatePresent(HttpServletRequest req, HttpServletResponse resp) {
        int id = Integer.parseInt(req.getParameter("id"));
        String code = req.getParameter("code");
        String name = req.getParameter("name");
        double price = Double.parseDouble(req.getParameter("price"));
        String ship = req.getParameter("ship");
        String img = req.getParameter("img");

        Present present = new Present(id, code, name, price, ship, img);
        try {
            presentDAO.updatePresent(present);
            req.setAttribute("message", "Present information was updated");
            RequestDispatcher dispatcher = req.getRequestDispatcher("present/edit.jsp");
            dispatcher.forward(req, resp);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void insertPresent(HttpServletRequest req, HttpServletResponse resp) {
        String code = req.getParameter("code");
        String name = req.getParameter("name");
        double price = Double.parseDouble(req.getParameter("price"));
        String ship = req.getParameter("ship");
        String img = req.getParameter("img");
        Present newPresent = new Present(code, name, price, ship, img);
        try {
            presentDAO.insertPresent(newPresent);
            req.setAttribute("message", "New present was created");
            RequestDispatcher dispatcher = req.getRequestDispatcher("present/create.jsp");
            dispatcher.forward(req, resp);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
