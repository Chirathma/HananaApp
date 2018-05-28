package org.hanana.hananaapp.events;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.hanana.hananaapp.R;
import org.hanana.hananaapp.models.Event;
import org.hanana.hananaapp.models.EventsRepository;

import java.util.List;


public class EventsFragment extends Fragment {

        private RecyclerView mEventsRecyclerView;
        private EventAdapter mAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_event_list, container, false);

        mEventsRecyclerView = (RecyclerView) view.findViewById(R.id.event_recycler_view);

        mEventsRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        updateUI();
        return view;
    }

    private void updateUI(){
        EventsRepository repository = EventsRepository.getInstance(getActivity());
        List <Event> events = repository.getAllEvents();

        mAdapter = new EventAdapter(events);
        mEventsRecyclerView.setAdapter(mAdapter);
    }



    private class EventHolder extends RecyclerView.ViewHolder{
        // ui instances
        private TextView mTitleTextView;
        private TextView mDateTextView;
        // event instance
        private Event mEvent;

        public EventHolder(LayoutInflater inflater, ViewGroup parent) {
            super(inflater.inflate(R.layout.list_item_event, parent, false));

            mTitleTextView = itemView.findViewById(R.id.event_title);
            mDateTextView = itemView.findViewById(R.id.event_date);
        }

        public void bind(Event event){
            mEvent = event;

            mTitleTextView.setText(mEvent.getTitle());
            mDateTextView.setText(mEvent.getDate().toString());
        }
    }

    private class EventAdapter extends RecyclerView.Adapter<EventHolder>{
        private List<Event> mEvents;

        public EventAdapter(List<Event> events) {
            mEvents = events;
        }

        @Override
        public EventHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from(getActivity());

            return new EventHolder(layoutInflater, parent);
        }

        @Override
        public void onBindViewHolder(EventHolder holder, int position) {
            Event event = mEvents.get(position);
            holder.bind(event);
        }

        @Override
        public int getItemCount() {
            return mEvents.size();
        }
    }
}
