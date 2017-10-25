package cn.utils;

import java.util.ArrayList;
import java.util.List;

public class ImageUtils {
	private String content;
	private List<String> imagelist=new ArrayList<String>();
	private List<String> imagelisttemp=new ArrayList<String>();
	public ImageUtils(String content) {
		this.content=content;
		setImageList(content);
		if(imagelist.size()>0){
			setContent(content);
		}
	}
	public String getContent() {
		return content;
	}
	private void setContent(String content) {
		for(int i=0;i<imagelisttemp.size();i++){
			String te=imagelisttemp.get(i);
			content=content.replace(te,"");
		}
		this.content=content;
	}
	public List<String> getImageList() {
		return imagelist;
	}
	private void setImageList(String content) {
		String begin="[Í¼Æ¬£º";
		String end="]";
		int frist=0;
		int last=0;
		for(int i=0;i<content.length();i++){			
			if(i<content.length()-4){
				if(content.substring(i, i+4).equals(begin)){
					frist=i;
					last=0;
				}
			}
			String ee=String.valueOf(content.charAt(i));
			if(ee.equals(end)){
				last=i+1;
			}
			if(frist!=0&&last!=0){
				this.imagelist.add(content.substring(frist+4, last-1));
				imagelisttemp.add(content.substring(frist, last));
				frist=0;
			}else{
				last=0;
			}	
		}
	}
}
