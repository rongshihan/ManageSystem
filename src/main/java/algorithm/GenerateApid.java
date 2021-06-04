package algorithm;

import DAO.AppointmentDAO;
import DAO.DAOFactory;
import model.Appointment;

import java.util.List;

//生成不重复的8位数预约号
public class GenerateApid {
    public String generate(){
        AppointmentDAO appointmentDAO = DAOFactory.getAppointmentDAO();
        List<Appointment> appointments = appointmentDAO.findAll();
        String ap_id;
        int ap_num = (int)(Math.random()*100000000);
        ap_id = Integer.toString(ap_num);
        while(ap_id.length()<8){
            ap_id = "0"+ ap_id;
        }
        for(Appointment ap:appointments){
            if(ap_id.equals(ap.getAppointment_id())){
                ap_num = (int)(Math.random()*100000000);
                ap_id = Integer.toString(ap_num);
                while(ap_id.length()<8){
                    ap_id = "0"+ ap_id;
                }
            }
        }
        return ap_id;
    }
}
