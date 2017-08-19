package com.bikebeacon.cch;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

public abstract class CCHDelegate extends HttpServlet {

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        informCCH();
    }

    @Override
    public void init() throws ServletException {
        super.init();
        informCCH();
    }

    @Override
    public void destroy() {
        super.destroy();
        CentralControlHub.getCCH().notifyDelegateEliminated(this);
    }

    private void informCCH() {
        CentralControlHub.getCCH().notifyDelegateCreation(this);
    }
}