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
package movies.spring.data.neo4j.services;

import movies.spring.data.neo4j.domain.Entity;
import org.springframework.data.neo4j.repository.Neo4jRepository;

import java.util.Optional;

public abstract class GenericService<T> implements Service<T> {

    private static final int DEPTH_LIST = 0;
    private static final int DEPTH_ENTITY = 1;

    @Override
    public Iterable<T> findAll() {
        return getRepository().findAll(DEPTH_LIST);
    }

    @Override
    public T find(Long id) {
        Optional<T> res =  getRepository().findById(id, DEPTH_ENTITY);
        //todo 是否要throw Exception
        return res.isPresent()? res.get():null;
    }

    @Override
    public void delete(Long id) {
        getRepository().deleteById(id);
    }

    @Override
    public T createOrUpdate(T entity) {
        getRepository().save(entity, DEPTH_ENTITY);
        return find(((Entity) entity).getId());
    }

    public abstract Neo4jRepository<T,Long> getRepository();
}
