package DAO;

import model.Appointment;

import java.util.List;

//Appointment表DAO接口
public interface AppointmentDAO {
    public Boolean insert(Appointment a);
    public Boolean update(Appointment a);
    public Boolean delete(String ap_id);
    public Appointment findById(String ap_id);
    public List<Appointment> findAll();
}
