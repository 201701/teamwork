package serviceImpl;

import dao.SignRecordDao;

import entity.SignRecord;
import entity.User;
import service.SignRecordService;
import util.DateUtil;
import dao.SignRecordDao2;

import javax.servlet.http.HttpSession;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class SignRecordServiceImpl implements SignRecordService {
    @Override
    public int userSign(String beginTime, String endTime, User user) {
//        鍒涘缓褰撳墠绛惧埌鏃堕棿
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat sdf2 = new SimpleDateFormat("HH:mm:SS");
        String signDate = sdf.format(date);
        String nowTime = sdf2.format(date);

        System.out.println(signDate+"------"+nowTime);

        if( nowTime.compareTo(beginTime) < 0 ){
            /*绛惧埌鏈紑濮�*/
            return 0;
        }else if (nowTime.compareTo(endTime) > 0){
            /*绛惧埌宸茬粨鏉�*/
            return 2;
        }else {
            /*鍚﹀垯绛惧埌鎴愬姛*/
            SignRecordDao2 srd = new SignRecordDao2();
            try {
                System.out.println("------鑺傜偣1:SignRecordServiceImpl鎵ц-------");
                srd.addSignRecord(DateUtil.stringToUdate(signDate),
                        DateUtil.stringToTime(beginTime),
                        DateUtil.stringToTime(endTime), user);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            return 1;
        }

    }

    @Override
    public List<SignRecord> searchUserSignToday(User user) {
        Date date = new Date();
        SimpleDateFormat adf = new SimpleDateFormat("yyyy-MM-dd");
        String today1 = adf.format(date);
        List<entity.SignRecord> list = null;
        try {
            Date today = DateUtil.stringToUdate(today1);
            SignRecordDao2 signRecordDao2 = new SignRecordDao2();
            list=signRecordDao2.searchUserSign(user, (java.sql.Date) today);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return list;
    }


}
