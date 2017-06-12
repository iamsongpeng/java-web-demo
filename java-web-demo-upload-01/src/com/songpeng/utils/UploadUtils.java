package com.songpeng.utils;

import java.util.UUID;

// 上传工具类
public class UploadUtils {

	// 根据原始文件名 生成 唯一的文件名
	// baby1.jpg ===> 唯一标识.jpg
	public static String createUUIDName(String filename) {
		// 获取原始文件名 的 扩展名 .jpg
		int lastIndexOf = filename.lastIndexOf(".");
		String ext = filename.substring(lastIndexOf);
		// 搞一个唯一标识
		String uuid = UUID.randomUUID().toString();
		// 拼接后返回
		return uuid + ext;
	}

	// 根据唯一文件名生成随机目录
	public static String createRandomPath(String uuidname) {
		// 根据文件名 获得hashcode值 int
		int hashCode = uuidname.hashCode();
		// 跟 0xf 进行&运算生成一级目录
		int one = hashCode & 0xf;
		// 再将 hashcode值 向右移动4位后 再跟 0xf 进行&运算生成二级目录
		int two = (hashCode >>> 4) & 0xf;
		return "/" + one + "/" + two;
	}

}
