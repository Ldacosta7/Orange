package com.example.orange;

import java.util.ArrayList;

public interface IIterventionObserver {
    public void onReceiveIntervention(ArrayList<Intervention> interventions);
}
