package info.dmerej;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashMap;
import java.util.List;

class NotifierTest implements Notifier {
  int count;
  public NotifierTest() {
    this.count = 0;
  }
  @Override
  public void notify(User user, String message) {
    HashMap<User, Integer> map = new HashMap<User, Integer>();
    map.put(user, count++);
    System.out.println(map);
  }
}

public class DiscountApplierTest {
  User Bob = new User("Bob", "bob@mail.test");
  User John = new User("John", "john@mail.test");

  @Test
  void should_notify_twice_when_applying_discount_for_two_users_v1() {
    NotifierTest notifier = new NotifierTest();
    DiscountApplier discountApplier = new DiscountApplier(notifier);
    List<User> user = new ArrayList<User>();
    user.add(Bob);
    user.add(John);
    discountApplier.applyV1(10, user);
    assertEquals(2, notifier.count);
  }

  @Test
  void should_notify_twice_when_applying_discount_for_two_users_v2() {
    NotifierTest notifierTest = new NotifierTest();
    DiscountApplier discountApplier = new DiscountApplier(notifierTest);
    List<User> user = new ArrayList<User>();
    user.add(Bob);
    user.add(John);
    discountApplier.applyV2(10, user);
    assertEquals(1, notifierTest.count);
  }

}
