package cn.benlocke.webservice.web.entity;

import java.util.List;
import lombok.Data;

@Data
public class Item {
	//private Long id;
	private String icon;
	private String index;
	private String title;
	private List<Item> subs;
}
