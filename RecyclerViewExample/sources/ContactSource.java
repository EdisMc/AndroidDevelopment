package bg.tu.varna.recyclerviewexample.data;

import java.util.ArrayList;
import java.util.Random;
import bg.tu.varna.recyclerviewexample.models.Contact;

public class ContactSource {

    public static ArrayList<Contact> generateList(int count) {
        ArrayList<Contact> contactList = new ArrayList<>();

        Random random = new Random();
        for (int i = 1; i <= count; i++) {
            contactList.add(new Contact(
                    "Person " + i,
                    100000000L + random.nextLong() % 999999999L
            ));
        }
        return contactList;
    }
}
