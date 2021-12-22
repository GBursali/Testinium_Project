package entities;

public interface ITestPage<T> {
    /**
     * Navigates to the base URL
     * @return Returning type
     */
    T navigate();

    T checkURL();
}
