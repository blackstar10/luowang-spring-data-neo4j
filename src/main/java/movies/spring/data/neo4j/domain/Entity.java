/*
 * Copyright [2011-2016] "Neo Technology"
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the specific language governing permissions and limitations under the License.
 *
 */
package movies.spring.data.neo4j.domain;

import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Properties;

@NodeEntity
public class Entity {

    @Id
    @GeneratedValue
    private Long id;

    @Properties
    private Long createTime = System.currentTimeMillis();
    private Long updateTime = System.currentTimeMillis();
    private boolean isNodeDeleted;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    public Long getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Long updateTime) {
        this.updateTime = updateTime;
    }

    public void updateTime() {
        this.updateTime = System.currentTimeMillis();;
    }

    public boolean isNodeDeleted() {
        return isNodeDeleted;
    }

    public void setNodeDeleted(boolean nodeDeleted) {
        isNodeDeleted = nodeDeleted;
    }
    /**
     * This is the default mechanism for providing entity identity to the OGM
     * <p>
     * It is required because the OGM can currently accept objects with NO
     * id value set. This is a restriction that must be changed
     *
     * @param o the object to compare, either or both may not yet be persisted.
     * @return
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || id == null || getClass() != o.getClass()) return false;

        Entity entity = (Entity) o;

        return id.equals(entity.id);
    }

    @Override
    public int hashCode() {
        return (id == null) ? -1 : id.hashCode();
    }

}
