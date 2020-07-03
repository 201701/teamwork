package service;

import entity.SignRecord;
import entity.User;

import java.util.List;

public interface SignRecordService {
    public int userSign(String beginTime, String endTime, User user);

    public List<SignRecord> searchUserSignToday(User user);
}
