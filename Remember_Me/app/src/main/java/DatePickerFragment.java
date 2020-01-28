import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.widget.CalendarView;

import java.util.Calendar;

public class DatePickerFragment extends DialogFragment {
    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
     /*   Calendar calendario = Calendar.getInstance();
        int year = calendario.get(Calendar.YEAR);
       int  month = calendario.get(Calendar.MONTH);
       int  day = calendario.get(Calendar.DAY_OF_MONTH);

        return new DatePickerDialog(getActivity(),(DatePickerDialog.OnDateSetListener) getActivity(), year, month, day);*/
    return null;}
}
