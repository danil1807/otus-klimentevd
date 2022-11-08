package components.popups;

public interface IPopup<T> {
  public T shouldNotBeVisible();

  public T shouldBeVisible();
}
