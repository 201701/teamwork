package service;

import entity.Sign;

import java.sql.Time;
import java.util.Date;
import java.util.List;

public interface SignListService {

   public void addSign(Date date, Time time1, Time time2);
   public void deleteSign(Date date, Time time1, Time time2);
   public void updateSign(Date date, Time time1, Time time2, Date dateNew, Time time1New, Time time2New);
   public List<Sign> listAllSignsByToday();
   public List<Sign> listAllSigns();
}
