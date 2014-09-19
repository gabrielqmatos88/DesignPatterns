/*
 * Copyright (c) 2014 HollowSoft @IgorMorais
 *
 * Licensed under the Apache License, Version 2.0 (the �License�);
 * you may not use this file except in compliance with the License.
 *
 *          You may obtain a copy of the License at
 *          http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an �AS IS� BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package pattern;

/**
 * @author Igor Morais
 * @author mor41s.1gor@gmail.com
 */
public final class DatabaseManager {

    /**
     * {@code DatabaseManager} static instance.
     */
    private static final DatabaseManager INSTANCE;

    /**
     *
     */
    static {
        INSTANCE = new DatabaseManager();
    }

    /**
     * Default private constructor.
     */
    private DatabaseManager() {

    }

    /**
     * Get instance from the {@code DatabaseManager}.
     *
     * @return The {@code DatabaseManager} instance.
     */
    public static DatabaseManager getInstance() {
        return INSTANCE;
    }
}
