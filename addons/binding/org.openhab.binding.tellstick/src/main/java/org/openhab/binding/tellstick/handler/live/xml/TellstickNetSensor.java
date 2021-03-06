/**
 * Copyright (c) 2014-2016 by the respective copyright holders.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.openhab.binding.tellstick.handler.live.xml;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import org.tellstick.device.iface.Device;
import org.tellstick.enums.DeviceType;

/**
 * Class used to deserialize XML from Telldus Live.
 *
 * @author Jarle Hjortland
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "sensor")
public class TellstickNetSensor implements Device {
    @XmlAttribute(name = "id")
    int deviceId;
    @XmlAttribute()
    private String protocol;
    @XmlAttribute()
    private String name;
    @XmlAttribute()
    @XmlJavaTypeAdapter(value = NumberToBooleanMapper.class)
    private Boolean online;
    @XmlElement(name = "data")
    private List<DataTypeValue> data;
    @XmlAttribute()
    private Long lastUpdated;
    private boolean updated;

    public TellstickNetSensor() {
    }

    public TellstickNetSensor(int id) {
        this.deviceId = id;
    }

    @Override
    public int getId() {
        return deviceId;
    }

    @Override
    public String getUUId() {
        return Integer.toString(deviceId);
    }

    @Override
    public String getProtocol() {
        return protocol;
    }

    @Override
    public DeviceType getDeviceType() {
        return DeviceType.SENSOR;
    }

    @Override
    public String getName() {
        return name;
    }

    public void setId(int deviceId) {
        this.deviceId = deviceId;
    }

    public void setProtocol(String protocol) {
        this.protocol = protocol;
    }

    public void setName(String name) {
        this.name = name;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("TellstickNetSensor [deviceId=").append(deviceId).append(", protocol=").append(protocol)
                .append(", name=").append(name).append(", online=").append(online).append(", data=").append(data)
                .append(", lastUpdated=").append(lastUpdated).append(", updated=").append(updated).append("]");
        return builder.toString();
    }

    public boolean getOnline() {
        return online;
    }

    // @XmlJavaTypeAdapter(value = NumberToBooleanMapper.class)
    public void setOnline(boolean online) {
        this.online = online;
    }

    public List<DataTypeValue> getData() {
        return data;
    }

    public void setData(List<DataTypeValue> data) {
        this.data = data;
    }

    @Override
    public String getModel() {
        return null;
    }

    public Long getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(Long lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + deviceId;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        TellstickNetSensor other = (TellstickNetSensor) obj;
        if (deviceId != other.deviceId) {
            return false;
        }
        return true;
    }

    public void setUpdated(boolean b) {
        this.updated = b;
    }

    public boolean isUpdated() {
        return updated;
    }
}
