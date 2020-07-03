package serviceImpl;

import dao.SignListDao;
import entity.Sign;
import service.SignListService;

import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class SignListServiceImpl implements SignListService {

    @Override
    public void addSign(Date date, Time time1, Time time2) {
        SignListDao signListDao = new SignListDao();
        signListDao.addSign(date, time1, time2);
    }

    @Override
    public void deleteSign(Date date, Time time1, Time time2) {
        SignListDao signListDao = new SignListDao();
        signListDao.deleteSign(date, time1, time2);
    }

    @Override
    public void updateSign(Date date, Time time1, Time time2, Date dateNew, Time time1New, Time time2New) {
        SignListDao signListDao = new SignListDao();
        signListDao.updateSign(date, time1, time2, dateNew, time1New, time2New);
    }

    @Override
    public List<Sign> listAllSignsByToday() {
        Date date = new Date();
        SimpleDateFormat adf = new SimpleDateFormat("yyyy-MM-dd");
        String today = adf.format(date);
        System.out.println("-----------gagagagagga----------");
        /*从数据库中获取当前年月日的签到项集合*/
        SignListDao signListDao = new SignListDao();
        return signListDao.listAllSignsByToday(today);
    }

    @Override
    public List<Sign> listAllSigns() {
        SignListDao signListDao = new SignListDao();
        return signListDao.listAllSigns();
    }


}
