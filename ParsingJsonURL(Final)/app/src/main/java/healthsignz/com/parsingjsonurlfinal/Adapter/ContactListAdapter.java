package healthsignz.com.parsingjsonurlfinal.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import healthsignz.com.parsingjsonurlfinal.Beans.ContactInfo;
import healthsignz.com.parsingjsonurlfinal.R;

/**
 * Created by devuser on 11-03-2016.
 */
public class ContactListAdapter extends ArrayAdapter<ContactInfo> {

    Context context ;
    List<ContactInfo> contactInfosList = new ArrayList<ContactInfo>();

    public ContactListAdapter(Context context, int resource, List<ContactInfo> contactInfosList) {
        super(context, resource, contactInfosList);
        this.context = context ;
        this.contactInfosList= contactInfosList;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View view = inflater.inflate(R.layout.row_contact_list,parent,false);

        TextView contactId = (TextView)view.findViewById(R.id.textview_contactid);
        TextView name = (TextView)view.findViewById(R.id.textview_name);
        TextView landNo = (TextView)view.findViewById(R.id.textview_landline_number);
        TextView mobileNo = (TextView)view.findViewById(R.id.textview_mobile_number);
        TextView emailId = (TextView)view.findViewById(R.id.textview_emailId);
        TextView remark = (TextView)view.findViewById(R.id.textview_remark);
        TextView city = (TextView)view.findViewById(R.id.textview_city);

        contactId.setText(contactInfosList.get(position).getContactId());
        name.setText(contactInfosList.get(position).getName());
        landNo.setText(contactInfosList.get(position).getLandno());
        mobileNo.setText(contactInfosList.get(position).getMobileNo());
        emailId.setText(contactInfosList.get(position).getEmailId());
        remark.setText(contactInfosList.get(position).getRemark());
        city.setText(contactInfosList.get(position).getCity());

        return view;


    }
}
