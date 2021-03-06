package android.example.miniproject1;
import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

class setVariable
{
    int currentInput = 0;

    public void setCurrentInput(int X){
        currentInput = X;
    }
    public int returnCurrentInput(){
        return currentInput;
    }
}

public class FastPowerFragment extends Fragment {
    public FastPowerFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fast_power_fragment, container, false);
        //return super.onCreateView(inflater, container, savedInstanceState);
        return view;
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {

        final TextView Garrow = (TextView) getView().findViewById(R.id.fast_pow_G_arrow);
        final TextView Ginput = (TextView) getView().findViewById(R.id.fast_pow_G_input);
        final TextView Xarrow = (TextView) getView().findViewById(R.id.fast_pow_X_arrow);
        final TextView Xinput = (TextView) getView().findViewById(R.id.fast_pow_X_input);
        final TextView Parrow = (TextView) getView().findViewById(R.id.fast_pow_P_arrow);
        final TextView Pinput = (TextView) getView().findViewById(R.id.fast_pow_P_input);

        savedInstanceState.putString("Garrow", Garrow.getText().toString());
        savedInstanceState.putString("Ginput", Ginput.getText().toString());
        savedInstanceState.putString("Xarrow", Xarrow.getText().toString());
        savedInstanceState.putString("Xinput", Xinput.getText().toString());
        savedInstanceState.putString("Parrow", Parrow.getText().toString());
        savedInstanceState.putString("Pinput", Pinput.getText().toString());

        super.onSaveInstanceState(savedInstanceState);
    }

    public void onActivityCreated(Bundle savedState) {
        super.onActivityCreated(savedState);

        Button Gbutton = (Button) getView().findViewById(R.id.fastPowGbutton);
        Button Xbutton = (Button) getView().findViewById(R.id.fastPowXbutton);
        Button Pbutton = (Button) getView().findViewById(R.id.fastPowPbutton);
        Button Enter = (Button) getView().findViewById(R.id.enter);
        final TextView Garrow = (TextView) getView().findViewById(R.id.fast_pow_G_arrow);
        final TextView Ginput = (TextView) getView().findViewById(R.id.fast_pow_G_input);
        final TextView Xarrow = (TextView) getView().findViewById(R.id.fast_pow_X_arrow);
        final TextView Xinput = (TextView) getView().findViewById(R.id.fast_pow_X_input);
        final TextView Parrow = (TextView) getView().findViewById(R.id.fast_pow_P_arrow);
        final TextView Pinput = (TextView) getView().findViewById(R.id.fast_pow_P_input);

        if (savedState != null) {
            // Restore last state for checked position.
            Garrow.setText(savedState.getString("Garrow"));
            Ginput.setText(savedState.getString("Ginput"));
            Xarrow.setText(savedState.getString("Xarrow"));
            Xinput.setText(savedState.getString("Xinput"));
            Parrow.setText(savedState.getString("Parrow"));
            Pinput.setText(savedState.getString("Pinput"));
        }

        setVariable setVar = new setVariable();
        TextView Equation = (TextView) getView().findViewById(R.id.fast_pow_equation);

        if (((CalculationActivity)getActivity()).getopertation() == "Fast Power") {
            Equation.setText(Html.fromHtml("G<sup>(answer)</sup> ≡ X mod P"));
        }
        else if (((CalculationActivity)getActivity()).getopertation() == "BabyStep GiantStep") {
            Equation.setText(Html.fromHtml("G<sup>X</sup> ≡ (answer) mod P"));
        }
        else Equation.setText(Html.fromHtml("G<sup>X</sup> ≡ (answer) mod P"));

        int currentInput = 0;

        Gbutton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                setVariable setVar = new setVariable();
                Garrow.setText("←");
                Xarrow.setText("    ");
                Parrow.setText("    ");
                setVar.setCurrentInput(0);
                ((CalculationActivity) getActivity()).setCurrentInput(0);
            }
        });
        Xbutton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                setVariable setVar = new setVariable();
                Garrow.setText("    ");
                Xarrow.setText("←");
                Parrow.setText("    ");
                setVar.setCurrentInput(1);
                ((CalculationActivity)getActivity()).setCurrentInput(1);
            }
        });
        Pbutton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                setVariable setVar = new setVariable();
                Garrow.setText("    ");
                Xarrow.setText("    ");
                Parrow.setText("←");
                setVar.setCurrentInput(2);
                ((CalculationActivity)getActivity()).setCurrentInput(2);
            }
        });
        Enter.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                final TextView result = (TextView) getView().findViewById(R.id.fastPowResult);
                ((CalculationActivity)getActivity()).runtheNumbers();
                result.setText(((CalculationActivity)getActivity()).returnAnswer());
            }
        });
    }

    void setInput(String inputText, int currentInput){
        final TextView Ginput = (TextView) getView().findViewById(R.id.fast_pow_G_input);
        final TextView Xinput = (TextView) getView().findViewById(R.id.fast_pow_X_input);
        final TextView Pinput = (TextView) getView().findViewById(R.id.fast_pow_P_input);
        switch(currentInput)
        {
            case 0:
                Ginput.setText(inputText);
                break;
            case 1:
                Xinput.setText(inputText);
                break;
            case 2:
                Pinput.setText(inputText);
                break;
            default: break;
        }
    }
}
