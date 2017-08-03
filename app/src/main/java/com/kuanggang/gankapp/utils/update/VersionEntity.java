package com.kuanggang.gankapp.utils.update;

import java.io.Serializable;

/**
 * @author KG on 2017/8/3.
 */
public class VersionEntity implements Serializable {

    public String name;
    public String version;
    public String changelog;
    public String versionShort;
    public String build;
    public String installUrl;
    public String install_url;
    public String update_url;
    public Binary binary;

}
