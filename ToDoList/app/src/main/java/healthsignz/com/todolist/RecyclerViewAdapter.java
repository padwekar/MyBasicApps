package healthsignz.com.todolist;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.support.v4.app.ActivityCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import static android.support.v4.app.ActivityCompat.invalidateOptionsMenu;

/**
 * Created by devuser on 17-03-2016.
 */
public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolderClass>{
    static List<String> items = new ArrayList<String>();
    Context context;

    public RecyclerViewAdapter(Context context,List<String> items) {

        this.items = items;
        this.context = context;
    }

    @Override
    public ViewHolderClass onCreateViewHolder(ViewGroup parent, int viewType) {

        LayoutInflater inflater = (LayoutInflater)parent.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View view = inflater.inflate(R.layout.row_item_layout,parent,false);

        return new ViewHolderClass(view);

    }

    @Override
    public void onBindViewHolder(ViewHolderClass holder, int position) {
        holder.textview_listText.setText(items.get(position));
    }

    @Override
    public int getItemCount() {

        return items.size();
    }

    public class ViewHolderClass extends RecyclerView.ViewHolder {
        TextView textview_listText;
        ImageButton imageButton_edit ;

        public ViewHolderClass(final View itemView) {
            super(itemView);
            textview_listText = (TextView)itemView.findViewById(R.id.textview_listText);
            imageButton_edit = (ImageButton)itemView.findViewById(R.id.btn_edit);
            imageButton_edit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    final Dialog dialog = new Dialog(imageButton_edit.getContext());
                    LayoutInflater inflater = (LayoutInflater)imageButton_edit.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                     View view = inflater.inflate(R.layout.dialog_view,(ViewGroup)imageButton_edit.getParent(),false);
                    dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                    final EditText editText_dialog = (EditText)view.findViewById(R.id.edittext_dialog);
                    editText_dialog.setText(items.get(getAdapterPosition()));
                    editText_dialog.setSelection((items.get(getAdapterPosition())).toString().length());
                    TextView textview_ok =(TextView)view.findViewById(R.id.labl_ok);
                    TextView textview_cancel =(TextView)view.findViewById(R.id.labl_cancel);
                    textview_ok.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            String newText = editText_dialog.getText().toString();
                            items.set(getAdapterPosition(), newText);
                            notifyDataSetChanged();
                            dialog.dismiss();
                        }
                    });
                    textview_cancel.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            dialog.dismiss();
                        }
                    });
                    dialog.setContentView(view);
                    dialog.create();
                    dialog.show();


                }
            });
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    items.remove(getAdapterPosition());
                    notifyItemRemoved(getAdapterPosition());
                //    mainActivity.menuChangeNotify();
                    ((MainActivity)context).invalidateOptionsMenu();
                }
            });


        }
    }
}
