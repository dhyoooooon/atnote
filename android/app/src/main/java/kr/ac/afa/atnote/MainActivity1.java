package kr.ac.afa.atnote;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;


public class MainActivity1 extends Fragment {

    private Context context;
    private TextView helloText = null;
    static boolean calledAlready = false;

    private FirebaseDatabase mDatabase;
    private DatabaseReference mReference;
    private ChildEventListener mChild;

    private ListView listView;
    private ArrayAdapter<String> adapter;
    List<Object> Array = new ArrayList<Object>();
    private Location location;

    public MainActivity1() {
        // required
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View layout = inflater.inflate(R.layout.test, container, false);
        helloText = (TextView) layout.findViewById(R.id.helloText);
        context = container.getContext();
        return layout;
    }

    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onStop() {
        super.onStop();
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        mDatabase = FirebaseDatabase.getInstance();

        mReference = mDatabase.getReference();
        mReference.child("users").addChildEventListener(new ChildEventListener() {  // message는 child의 이벤트를 수신합니다.
                                             @Override
                                             public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                                                 location = dataSnapshot.getValue(Location.class);  // chatData를 가져오고
                                                 helloText.setText((CharSequence) location.getPlace_address());
                                                 helloText.setText((CharSequence) location.place_address);

                                             }

                                             @Override
                                             public void onChildChanged(DataSnapshot dataSnapshot, String s) {

                                             }

                                             @Override
                                             public void onChildRemoved(DataSnapshot dataSnapshot) {
                                             }

                                             @Override
                                             public void onChildMoved(DataSnapshot dataSnapshot, String s) {

                                             }

                                             @Override
                                             public void onCancelled(DatabaseError databaseError) {

                                             }
                                         });
    }
}
