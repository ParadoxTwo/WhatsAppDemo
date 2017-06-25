package paradox.com.whatsappdemo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * Created by winbr on 6/24/2017.
 */

public class ChatActivity extends Fragment {
    ArrayList<Person> personArrayList = new ArrayList<>();
    RecyclerView personList;
    RecyclerView.LayoutManager layoutManager;
    PeopleAdapter personAdapter;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.frag_chat,container,false);
        if(personArrayList.size()==0) {
            personArrayList.add(new Person("Edwin", "edwin","Am I talking to myself?", "Yesterday"));
            personArrayList.add(new Person("Byjen", "byjen","bye", "Today"));
            personArrayList.add(new Person("Happy", "happy","bye", "3:30pm"));
            personArrayList.add(new Person("Rebecca", "rebecca","okay", "2:00pm"));
            personArrayList.add(new Person("Ancy", "ancy","bye", "2:30pm"));
            personArrayList.add(new Person("Jeremy", "jeremy","TC", "5:30pm"));
            personArrayList.add(new Person("Nikhil", "nikhil","ttyl", "1:30pm"));
            personArrayList.add(new Person("Feba", "feba","bye", "12:30pm"));
        }
        personList = (RecyclerView) v.findViewById(R.id.chatRecycler);
        layoutManager = new LinearLayoutManager(
            v.getContext()
        );
        personList.setLayoutManager(layoutManager);
        personAdapter = new PeopleAdapter(personArrayList, v.getContext(), R.layout.frag_chat_content);
        personList.setAdapter(personAdapter);
        return v;
    }
}
