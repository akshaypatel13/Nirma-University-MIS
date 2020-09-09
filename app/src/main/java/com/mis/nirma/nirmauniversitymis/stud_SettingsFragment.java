package com.mis.nirma.nirmauniversitymis;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by bhautik on 9/10/16.
 */
public class stud_SettingsFragment extends Fragment{

    View resultview;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        resultview = inflater.inflate(R.layout.stud_settings,container,false);
        return resultview;
    }
}
