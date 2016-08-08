package com.dataprocess.bods.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * The Class ConfiguratorBinariesEO.
 */
@Entity
@Table(name = "BODS_CFG_BINARIES")
public final class ConfiguratorBinariesEO {

    /** The configurator id. */
    @Id
    @Column(name = "CONFIGURATOR_ID")
    private int configuratorId;

    /** The object. */
    @Column(name = "OBJECT")
    private byte[] object;

    /**
     * Gets the configurator id.
     *
     * @return the configurator id
     */
    public int getConfiguratorId() {
        return configuratorId;
    }

    /**
     * Sets the configurator id.
     *
     * @param configuratorId the new configurator id
     */
    public void setConfiguratorId(int configuratorId) {
        this.configuratorId = configuratorId;
    }

    /**
     * Gets the object.
     *
     * @return the object
     */
    public byte[] getObject() {
        return object;
    }

    /**
     * Sets the object.
     *
     * @param object the new object
     */
    public void setObject(byte[] object) {
        this.object = object;
    }

}
