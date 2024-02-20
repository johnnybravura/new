/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class BankomatServlet extends HttpServlet {

    static int Par1;
    static int Par2;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet BankomatServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>BankomatServlet</h1>");

            if (Par2 == 1) { // Wplata
                out.println("<p>Wplacono " + Par1 + " PLN. Stan konta po wplacie.</p>");
            } else if (Par2 == 2) { // Wyplata
                int[] banknotes = withdraw(Par1);
                if (banknotes == null) {
                    out.println("<p>Nie mozna wypłacić danej kwoty. Brak odpowiednich banknotów.</p>");
                } else {
                    out.println("<p>Wypłacono " + Par1 + " PLN w banknotach:</p>");
                    out.println("<ul>");
                    out.println("<li>200 PLN x " + banknotes[0] + "</li>");
                    out.println("<li>100 PLN x " + banknotes[1] + "</li>");
                    out.println("<li>50 PLN x " + banknotes[2] + "</li>");
                    out.println("<li>20 PLN x " + banknotes[3] + "</li>");
                    out.println("</ul>");
                }
            }

            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Par1 = Integer.parseInt(request.getParameter("amount"));
        Par2 = Integer.parseInt(request.getParameter("operation"));
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Par1 = Integer.parseInt(request.getParameter("amount"));
        Par2 = Integer.parseInt(request.getParameter("operation"));
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

    private int[] withdraw(int amount) {
        // Implement your logic for withdrawing the amount using the minimum number of banknotes.
        // Return an array representing the number of 200 PLN, 100 PLN, 50 PLN, and 20 PLN banknotes.
        // If withdrawal is not possible, return null.
        // You can use different algorithms like greedy algorithm to find the optimal combination.
        // For simplicity, I'll provide a basic example below:

        int[] banknotes = new int[4];
        int remainingAmount = amount;

        banknotes[0] = remainingAmount / 200;
        remainingAmount %= 200;

        banknotes[1] = remainingAmount / 100;
        remainingAmount %= 100;

        banknotes[2] = remainingAmount / 50;
        remainingAmount %= 50;

        banknotes[3] = remainingAmount / 20;
        remainingAmount %= 20;

        // Check if the exact amount could be withdrawn
        if (remainingAmount == 0) {
            return banknotes;
        } else {
            return null;
        }
    }
}
