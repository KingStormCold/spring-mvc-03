package com.example.utils;

import com.example.constant.SystemConstant;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class MessageUtil {

    public Map<String, String> getMessageResponse(String message) {
        Map<String, String> results = new HashMap<>();
        if (message != null) {
            if (message.equals(SystemConstant.INSERT_SUCCESS)) {
                results.put(SystemConstant.ALERT, "success");
                results.put(SystemConstant.MESSAGE_RESPONSE, "Thêm thành công");
            } else if (message.equals(SystemConstant.UPDATE_SUCCESS)) {
                results.put(SystemConstant.ALERT, "success");
                results.put(SystemConstant.MESSAGE_RESPONSE, "Cập nhật thành công");
            } else if (message.equals(SystemConstant.DELETE_SUCCESS)) {
                results.put(SystemConstant.ALERT, "success");
                results.put(SystemConstant.MESSAGE_RESPONSE, "Xóa thành công");
            } else if (message.equals(SystemConstant.ERROR_SYSTEM)) {
                results.put(SystemConstant.ALERT, "danger");
                results.put(SystemConstant.MESSAGE_RESPONSE, "Có lỗi xảy ra!");
            }
        }
        return results;
    }
}
