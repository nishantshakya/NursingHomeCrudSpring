package com.siue.nursingHome;

import java.util.List;

public interface NursingHomeDAO
{
    public void saveNursingHome(NursingHome employee);
    public NursingHome getNursingHomeById(String id);
    public void updateNursingHome(NursingHome employee,String id);
    public void deleteNursingHome(String id);
    public List<NursingHome> getAllNursingHomes();

    public List<Deficiency> getDeficienyData(String name, int td, int ic);

    public List<Fines> getFinesData(String number, String name, String type, int orating, int srating);

    public List<TopNursingHome> getStateListSearchData(String state);
}
