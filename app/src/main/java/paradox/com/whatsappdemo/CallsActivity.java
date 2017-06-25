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

public class CallsActivity extends Fragment {
    ArrayList<Person> personArrayList = new ArrayList<>();
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.frag_calls,container,false);
        if(personArrayList.size()==0) {
            personArrayList.add(new Person("Edwin", "edwin", true, "Yesterday"));
            personArrayList.add(new Person("Feba", "feba", false, "2pm"));
        }
        RecyclerView personList = (RecyclerView) v.findViewById(R.id.callsRecycler);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(
                v.getContext()
        );
        personList.setLayoutManager(layoutManager);
        PeopleAdapter personAdapter = new PeopleAdapter(personArrayList,v.getContext(),R.layout.frag_calls_content);
        personList.setAdapter(personAdapter);
        return v;
    }
}
