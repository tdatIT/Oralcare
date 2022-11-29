package com.oralcare.webapp.email;

import com.oralcare.webapp.model.Order;

public class EmailOrder {
    private Order order;
    private String name;

    public EmailOrder(Order order, String name) {
        this.order = order;
        this.name = name;
    }

    public String htmlContent() {
        return "<!doctype html>\n" +
                "<html class=\"h-100\" lang=\"en\">\n" +
                "<head>\n" +
                "</head>\n" +
                "<body data-bs-spy=\"scroll\" data-bs-target=\"#navScroll\">\n" +
                "  <div class=\" w-100 overflow-hidden\">\n" +
                "    <div class=\"content\">\n" +
                "      <div class=\"container\">\n" +
                "        <div class=\"row\">\n" +
                "          <div class=\"col-lg-4 col-md-4 col-sm-5 col-xs-12 position-fixed\">\n" +
                "            <div class=\"widget\">\n" +
                "              <h4 class=\"widget-title\">Thông tin đơn hàng</h4>\n" +
                "              <div class=\"summary-block\" id=\"chi-nha-khoa\">\n" +
                "                <div class=\"summary-content\">\n" +
                "                  <div class=\"summary-head\">\n" +
                "                    <h5 class=\"summary-title\">Tên khách hàng</h5>\n" +
                "                  </div>\n" +
                "                  <div class=\"summary-price\">\n" +
                "                    <p class=\"summary-text\" id=\"price-1\">"+name+"</p>\n" +
                "                    <span class=\"summary-small-text pull-right\">---</span>\n" +
                "                  </div>\n" +
                "                </div>\n" +
                "              </div>\n" +
                "              <div class=\"summary-block\" id=\"ban-chay\">\n" +
                "                <div class=\"summary-content\">\n" +
                "                  <div class=\"summary-head\">\n" +
                "                    <h5 class=\"summary-title\">Địa chỉ</h5>\n" +
                "                  </div>\n" +
                "                  <div class=\"summary-price\">\n" +
                "                    <p class=\"summary-text\" id=\"price-2\">"+order.getAddress()+"</p>\n" +
                "                    <span class=\"summary-small-text pull-right\">---</span>\n" +
                "                  </div>\n" +
                "                </div>\n" +
                "              </div>\n" +
                "              <div class=\"summary-block\" id=\"kem-danh-rang\">\n" +
                "                <div class=\"summary-content\">\n" +
                "                  <div class=\"summary-head\">\n" +
                "                    <h5 class=\"summary-title\">Tổng đơn hàng</h5>\n" +
                "                  </div>\n" +
                "                  <div class=\"summary-price\">\n" +
                "                    <p class=\"summary-text\" id=\"price-3\">"+order.getAmount()+"</p>\n" +
                "                    <span class=\"summary-small-text pull-right\">VND</span>\n" +
                "                  </div>\n" +
                "                </div>\n" +
                "              </div>\n" +
                "              <div class=\"summary-block\">\n" +
                "                <div class=\"summary-content\">\n" +
                "                  <div class=\"summary-head\">\n" +
                "                    <h5 class=\"summary-title\">Ngày đặt hàng</h5>\n" +
                "                  </div>\n" +
                "                  <div class=\"summary-price\">\n" +
                "                    <p class=\"summary-text\" id=\"quantity-total\">"+order.getCreateDate()+"</p>\n" +
                "                    <span class=\"summary-small-text pull-right\">---</span>\n" +
                "                  </div>\n" +
                "                </div>\n" +
                "              </div>\n" +
                "            </div>\n" +
                "\n" +
                "          </div>\n" +
                "        </div>\n" +
                "      </div>\n" +
                "    </div>\n" +
                "  </div>\n" +
                "</body>\n" +
                "<style>\n" +
                "  body {\n" +
                "    -webkit-font-smoothing: antialiased;\n" +
                "    text-rendering: optimizeLegibility;\n" +
                "    font-family: 'Noto Sans', sans-serif;\n" +
                "    letter-spacing: 0px;\n" +
                "    font-size: 14px;\n" +
                "    color: #2e3139;\n" +
                "    font-weight: 400;\n" +
                "    line-height: 26px;\n" +
                "}\n" +
                "h1,\n" +
                "h2,\n" +
                "h3,\n" +
                "h4,\n" +
                "h5,\n" +
                "h6 {\n" +
                "    letter-spacing: 0px;\n" +
                "    font-weight: 400;\n" +
                "    color: #1c1e22;\n" +
                "    margin: 0px 0px 15px 0px;\n" +
                "    font-family: 'Noto Sans', sans-serif;\n" +
                "}\n" +
                "\n" +
                "h1 {\n" +
                "    font-size: 42px;\n" +
                "    line-height: 50px;\n" +
                "}\n" +
                "\n" +
                "h2 {\n" +
                "    font-size: 36px;\n" +
                "    line-height: 42px;\n" +
                "}\n" +
                "\n" +
                "h3 {\n" +
                "    font-size: 20px;\n" +
                "    line-height: 32px;\n" +
                "}\n" +
                "\n" +
                "h4 {\n" +
                "    font-size: 18px;\n" +
                "    line-height: 32px;\n" +
                "}\n" +
                "\n" +
                "h5 {\n" +
                "    font-size: 14px;\n" +
                "    line-height: 20px;\n" +
                "}\n" +
                "\n" +
                "h6 {\n" +
                "    font-size: 12px;\n" +
                "    line-height: 18px;\n" +
                "}\n" +
                "\n" +
                "p {\n" +
                "    margin: 0 0 20px;\n" +
                "    line-height: 1.8;\n" +
                "}\n" +
                "\n" +
                "p:last-child {\n" +
                "    margin: 0px;\n" +
                "}\n" +
                "\n" +
                "ul,\n" +
                "ol {}\n" +
                "\n" +
                "a {\n" +
                "    text-decoration: none;\n" +
                "    color: #2e3139;\n" +
                "    -webkit-transition: all 0.3s;\n" +
                "    -moz-transition: all 0.3s;\n" +
                "    transition: all 0.3s;\n" +
                "}\n" +
                "\n" +
                "a:focus,\n" +
                "a:hover {\n" +
                "    text-decoration: none;\n" +
                "    color: #0943c6;\n" +
                "}\n" +
                "\n" +
                ".content {\n" +
                "    padding-top: 80px;\n" +
                "    padding-bottom: 80px\n" +
                "}\n" +
                ";\n" +
                "/*------------------------\n" +
                "Radio & Checkbox CSS\n" +
                "-------------------------*/\n" +
                ".form-control {\n" +
                "    border-radius: 4px;\n" +
                "    font-size: 14px;\n" +
                "    font-weight: 500;\n" +
                "    width: 100%;\n" +
                "    height: 70px;\n" +
                "    padding: 14px 18px;\n" +
                "    line-height: 1.42857143;\n" +
                "    border: 1px solid #dfe2e7;\n" +
                "    background-color: #dfe2e7;\n" +
                "    text-transform: capitalize;\n" +
                "    letter-spacing: 0px;\n" +
                "    margin-bottom: 16px;\n" +
                "    -webkit-box-shadow: inset 0 0px 0px rgba(0, 0, 0, .075);\n" +
                "    box-shadow: inset 0 0px 0px rgba(0, 0, 0, .075);\n" +
                "    -webkit-appearance: none;\n" +
                "}\n" +
                ".box {\n" +
                "    background-color: #fff;\n" +
                "    border-radius: 8px;\n" +
                "    border: 2px solid #e9ebef;\n" +
                "    padding: 50px;\n" +
                "    margin-bottom: 40px;\n" +
                "}\n" +
                ".box-title {\n" +
                "    margin-bottom: 30px;\n" +
                "    text-transform: uppercase;\n" +
                "    font-size: 16px;\n" +
                "    font-weight: 700;\n" +
                "    color: #094bde;\n" +
                "    letter-spacing: 2px;\n" +
                "}\n" +
                "\n" +
                ".plan-selection {\n" +
                "    border-bottom: 2px solid #e9ebef;\n" +
                "    padding-bottom: 25px;\n" +
                "    margin-bottom: 35px;\n" +
                "}\n" +
                "\n" +
                ".plan-selection:last-child {\n" +
                "    border-bottom: 0px;\n" +
                "    margin-bottom: 0px;\n" +
                "    padding-bottom: 0px;\n" +
                "}\n" +
                "\n" +
                ".plan-data {\n" +
                "    position: relative;\n" +
                "}\n" +
                "\n" +
                ".plan-data label ,select {\n" +
                "    font-size: 20px;\n" +
                "    margin-bottom: 15px;\n" +
                "    font-weight: 400;\n" +
                "}\n" +
                ".plan-data select {\n" +
                "    width: 70%;\n" +
                "    font-size: 2vh;\n" +
                "    margin-bottom: 15px;\n" +
                "    font-weight: 400;\n" +
                "}\n" +
                "\n" +
                ".plan-text {\n" +
                "    padding-left: 35px;\n" +
                "}\n" +
                "\n" +
                ".plan-price {\n" +
                "    position: absolute;\n" +
                "    right: 0px;\n" +
                "    color: #094bde;\n" +
                "    font-size: 20px;\n" +
                "    font-weight: 700;\n" +
                "    letter-spacing: -1px;\n" +
                "    line-height: 1.5;\n" +
                "    bottom: 43px;\n" +
                "}\n" +
                "\n" +
                ".term-price {\n" +
                "    bottom: 18px;\n" +
                "}\n" +
                "\n" +
                ".secure-price {\n" +
                "    bottom: 68px;\n" +
                "}\n" +
                "\n" +
                ".summary-block {\n" +
                "    border-bottom: 2px solid #d7d9de;\n" +
                "}\n" +
                "\n" +
                ".summary-block:last-child {\n" +
                "    border-bottom: 0px;\n" +
                "}\n" +
                "\n" +
                ".summary-content {\n" +
                "    padding: 28px 0px;\n" +
                "}\n" +
                "\n" +
                ".summary-price {\n" +
                "    color: #094bde;\n" +
                "    font-size: 20px;\n" +
                "    font-weight: 400;\n" +
                "    letter-spacing: -1px;\n" +
                "    margin-bottom: 0px;\n" +
                "    display: inline-block;\n" +
                "    float: right;\n" +
                "}\n" +
                "\n" +
                ".summary-small-text {\n" +
                "    font-weight: 700;\n" +
                "    font-size: 12px;\n" +
                "    color: #8f929a;\n" +
                "}\n" +
                "\n" +
                ".summary-text {\n" +
                "    margin-bottom: -10px;\n" +
                "}\n" +
                "\n" +
                ".summary-title {\n" +
                "    font-weight: 700;\n" +
                "    font-size: 14px;\n" +
                "    color: #1c1e22;\n" +
                "}\n" +
                "\n" +
                ".summary-head {\n" +
                "    display: inline-block;\n" +
                "    width: 120px;\n" +
                "}\n" +
                "\n" +
                ".widget {\n" +
                "    margin-bottom: 30px;\n" +
                "    background-color: #e9ebef;\n" +
                "    padding: 50px;\n" +
                "    border-radius: 6px;\n" +
                "}\n" +
                "\n" +
                ".widget:last-child {\n" +
                "    border-bottom: 0px;\n" +
                "}\n" +
                "\n" +
                ".widget-title {\n" +
                "    color: #094bde;\n" +
                "    font-size: 16px;\n" +
                "    font-weight: 700;\n" +
                "    text-transform: uppercase;\n" +
                "    margin-bottom: 25px;\n" +
                "    letter-spacing: 1px;\n" +
                "    display: table;\n" +
                "    line-height: 1;\n" +
                "}\n" +
                "\n" +
                ".btn {\n" +
                "    font-family: 'Noto Sans', sans-serif;\n" +
                "    font-size: 16px;\n" +
                "    text-transform: capitalize;\n" +
                "    font-weight: 700;\n" +
                "    padding: 12px 36px;\n" +
                "    border-radius: 4px;\n" +
                "    line-height: 2;\n" +
                "    letter-spacing: 0px;\n" +
                "    -webkit-transition: all 0.3s;\n" +
                "    -moz-transition: all 0.3s;\n" +
                "    transition: all 0.3s;\n" +
                "    word-wrap: break-word;\n" +
                "    white-space: normal !important;\n" +
                "}\n" +
                "\n" +
                ".btn-default {\n" +
                "    background-color: #0943c6;\n" +
                "    color: #fff;\n" +
                "    border: 1px solid #0943c6;\n" +
                "}\n" +
                "\n" +
                ".btn-default:hover {\n" +
                "    background-color: #063bb3;\n" +
                "    color: #fff;\n" +
                "    border: 1px solid #063bb3;\n" +
                "}\n" +
                "\n" +
                ".btn-default.focus,\n" +
                ".btn-default:focus {\n" +
                "    background-color: #063bb3;\n" +
                "    color: #fff;\n" +
                "    border: 1px solid #063bb3;\n" +
                "}\n" +
                "</style>\n" +
                "</html>";
    }
}
