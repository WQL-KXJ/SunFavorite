package com.kxj.WebPageCollect.service.serviceimpl;

import cn.hutool.core.util.RandomUtil;
import com.kxj.WebPageCollect.entity.UserEntity;
import com.kxj.WebPageCollect.repsitory.userRepsitory;
import com.kxj.WebPageCollect.service.PersopnalCenterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ClassUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;

/*
 * @Author WQL-KXJ
 * @ProjectName WebPageCollect
 * @PackageName com.kxj.WebPageCollect.service.serviceimpl
 * @Date 2022/9/20 23:39
 * @Version 1.0
 */
@Service
public class PersopnalCenterServiceImpl implements PersopnalCenterService {

    @Autowired
    userRepsitory userRepistory;

    @Autowired
    HttpServletRequest request;

    @Override
    public String uploadImage(MultipartFile oldfile, UserEntity userentity) throws IOException {

        //获取文件名
        String originalFilename = oldfile.getOriginalFilename();

        //获取文件后缀
        String substring = originalFilename.substring(originalFilename.lastIndexOf("."));

        //获取路径
        String path = ClassUtils.getDefaultClassLoader().getResource("").getPath() + "static/images/";

        String filepath = RandomUtil.randomString(8)+substring;

        File newfile = new File(path+filepath);

        //删除原有文件
        DelOldImage(userentity);

        userentity.setAvater("/images/"+filepath);

        //更新
        userRepistory.save(userentity);

        oldfile.transferTo(newfile);

        return "/images/"+filepath;
    }

    //删除修改前的image
    public Boolean DelOldImage(UserEntity userentity){
        Boolean a=false;

        //获取路径
        String path = ClassUtils.getDefaultClassLoader().getResource("").getPath() + "static/";

        //删除原有的文件
        File olefile = new File(path+userentity.getAvater());

        if(olefile.exists()){
            a = olefile.delete();
        }
        return a;
    }


}
