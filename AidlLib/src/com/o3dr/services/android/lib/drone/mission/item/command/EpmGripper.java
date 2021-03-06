package com.o3dr.services.android.lib.drone.mission.item.command;

import android.os.Parcel;

import com.o3dr.services.android.lib.drone.mission.item.MissionItem;
import com.o3dr.services.android.lib.drone.mission.MissionItemType;

/**
 * Created by fhuya on 11/6/14.
 */
public class EpmGripper extends MissionItem implements MissionItem.Command, android.os.Parcelable {

    private boolean release;

    public EpmGripper(){
        super(MissionItemType.EPM_GRIPPER);
    }

    public boolean isRelease() {
        return release;
    }

    public void setRelease(boolean release) {
        this.release = release;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        super.writeToParcel(dest, flags);
        dest.writeByte(release ? (byte) 1 : (byte) 0);
    }

    private EpmGripper(Parcel in) {
        super(in);
        this.release = in.readByte() != 0;
    }

    public static final Creator<EpmGripper> CREATOR = new Creator<EpmGripper>() {
        public EpmGripper createFromParcel(Parcel source) {
            return new EpmGripper(source);
        }

        public EpmGripper[] newArray(int size) {
            return new EpmGripper[size];
        }
    };
}
