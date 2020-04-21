package ru.job4j.Inheritance;

public class ReportUsage {

    public static void main(String[] args) {
        TextReport TextReport = new TextReport();
        String text = TextReport.generate("Report's name", "Report's body");
        System.out.println(text);

        HtmlReport HtmlReport = new HtmlReport();
        String text2 = HtmlReport.generate("Report's name", "Report's body");
        System.out.println(text2);

        JSONReport jsonReport = new JSONReport();
        String text3 = jsonReport.generate("Report's name", "Report's body");
        System.out.println(text3);
    }
}
