package menu.view;


public class ConsoleOutputView implements OutputView {

    @Override
    public void printErrorMessage(final String message) {
        System.out.println(message);
    }

    private void outputTitle(String title) {
        System.out.println("<" + title + ">");
    }

}
