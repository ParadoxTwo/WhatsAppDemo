package paradox.com.whatsappdemo;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by winbr on 6/19/2017.
 */

public class PeopleAdapter extends  RecyclerView.Adapter<PeopleAdapter.ViewHolder> {
    ArrayList<Person> personArrayList;
    Context context;
    int ID;
    public PeopleAdapter(ArrayList<Person> p, Context c, int id){
        context=c;
        personArrayList = p;
        ID=id;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater l = LayoutInflater.from(context);
        View v = l.inflate(ID, parent,false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Person s = personArrayList.get(position);
        holder.name.setText(s.getName());
        holder.date.setText(s.getDate());
        try{
            holder.msg.setText(s.getMsg());
        }
        catch(Exception ef){}
        holder.content.setImageResource(context.getResources().getIdentifier(s.getContent(), "drawable", context.getPackageName()));
        try {
            if (s.getCall())
                holder.call.setImageResource(R.drawable.call_recieved);
            else
                holder.call.setImageResource(R.drawable.call_missed);
        }
        catch(Exception e){
        }
    }

    @Override
    public int getItemCount() {
        return personArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        public ViewHolder(View item){
            super(item);
            try {
                call = (ImageView) item.findViewById(R.id.called);
                isCall=true;
            }
            catch(Exception e){
                isCall=false;
            }
            finally {
                content = (ImageView) item.findViewById(R.id.face);
                name = (TextView) item.findViewById(R.id.name);
                date = (TextView) item.findViewById(R.id.time);
            }
            try{
                msg= (TextView) item.findViewById(R.id.msg);
            }
            catch(Exception ef){}
        }
        Boolean isCall;
        TextView name, date, msg;
        ImageView content, call;
    }
}
