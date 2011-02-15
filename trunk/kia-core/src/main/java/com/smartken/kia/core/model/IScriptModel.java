package com.smartken.kia.core.model;

import java.io.Serializable;

public interface IScriptModel extends Serializable {

	public final static String SCRIPT_START="<script type=\"text/javascript\" language=\"javascript\">";
	public final static String SCRIPT_END="</script>";

	public String toScirpt();
	
}
