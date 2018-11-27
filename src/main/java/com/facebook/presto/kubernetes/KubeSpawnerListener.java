/*
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.facebook.presto.kubernetes;

import com.facebook.presto.spi.eventlistener.EventListener;
import com.facebook.presto.spi.eventlistener.QueryCompletedEvent;
import com.facebook.presto.spi.eventlistener.QueryCreatedEvent;
import com.facebook.presto.spi.eventlistener.SplitCompletedEvent;
import io.kubernetes.client.ApiClient;
import io.kubernetes.client.ApiException;
import io.kubernetes.client.Configuration;
import io.kubernetes.client.apis.CoreV1Api;
import io.kubernetes.client.models.V1Pod;
import io.kubernetes.client.models.V1PodList;
import io.kubernetes.client.util.Config;

import java.io.IOException;
import java.util.Map;
import java.util.logging.Logger;

public class KubeSpawnerListener
        implements EventListener
{
    Logger logger;
    final String loggerName = "QueryLog";

    public KubeSpawnerListener() {
    }

    public KubeSpawnerListener(Map<String, String> config) {
    }

    public void queryCreated(QueryCreatedEvent queryCreatedEvent) {

        ApiClient client = null;
        try {
            client = Config.defaultClient();
            Configuration.setDefaultApiClient(client);

            CoreV1Api api = new CoreV1Api();
            V1PodList list = api.listPodForAllNamespaces(null, null, null,
                    null, null, null, null, null, null);
            for (V1Pod item : list.getItems()) {
                System.out.println(item.getMetadata().getName());
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ApiException e) {
            e.printStackTrace();
        }


//        StringBuilder msg = new StringBuilder();
//
//        try {
//
//            msg.append("---------------Query Created----------------------------");
//            msg.append("\n");
//            msg.append("     ");
//            msg.append("Query ID: ");
//            msg.append(queryCreatedEvent.getMetadata().getQueryId().toString());
//            msg.append("\n");
//            msg.append("     ");
//            msg.append("Query State: ");
//            msg.append(queryCreatedEvent.getMetadata().getQueryState().toString());
//            msg.append("\n");
//            msg.append("     ");
//            msg.append("User: ");
//            msg.append(queryCreatedEvent.getContext().getUser().toString());
//            msg.append("\n");
//            msg.append("     ");
//            msg.append("Create Time: ");
//            msg.append(queryCreatedEvent.getCreateTime());
//            msg.append("\n");
//            msg.append("     ");
//            msg.append("Principal: ");
//            msg.append(queryCreatedEvent.getContext().getPrincipal());
//            msg.append("\n");
//            msg.append("     ");
//            msg.append("Remote Client Address: ");
//            msg.append(queryCreatedEvent.getContext().getRemoteClientAddress());
//            msg.append("\n");
//            msg.append("     ");
//            msg.append("Source: ");
//            msg.append(queryCreatedEvent.getContext().getSource());
//            msg.append("\n");
//            msg.append("     ");
//            msg.append("User Agent: ");
//            msg.append(queryCreatedEvent.getContext().getUserAgent());
//            msg.append("\n");
//            msg.append("     ");
//            msg.append("Catalog: ");
//            msg.append(queryCreatedEvent.getContext().getCatalog());
//            msg.append("\n");
//            msg.append("     ");
//            msg.append("Schema: ");
//            msg.append(queryCreatedEvent.getContext().getSchema());
//            msg.append("\n");
//            msg.append("     ");
//            msg.append("Server Address: ");
//            msg.append(queryCreatedEvent.getContext().getServerAddress());
//
//            logger.info(msg.toString());
//        }
//        catch (Exception ex) {
//
//            logger.info(ex.getMessage());
//        }

    }

    public void queryCompleted(QueryCompletedEvent queryCompletedEvent) {
//        String errorCode = null;
//        StringBuilder msg = new StringBuilder();
//
//        try {
//            errorCode = queryCompletedEvent.getFailureInfo().get().getErrorCode().getName().toString();
//        }
//        catch (NoSuchElementException noElEx) {
//            errorCode = null;
//        }
//
//        try {
//
//            if (errorCode != null) {
//
//                msg.append("---------------Query Completed----------------------------");
//                msg.append("\n");
//                msg.append("     ");
//                msg.append("Query ID: ");
//                msg.append(queryCompletedEvent.getMetadata().getQueryId().toString());
//                msg.append("\n");
//                msg.append("     ");
//                msg.append("Create Time: ");
//                msg.append(queryCompletedEvent.getCreateTime());
//                msg.append("\n");
//                msg.append("     ");
//                msg.append("User: ");
//                msg.append(queryCompletedEvent.getContext().getUser().toString());
//                msg.append("\n");
//                msg.append("     ");
//                msg.append("Complete: ");
//                msg.append(queryCompletedEvent.getStatistics().isComplete());
//                msg.append("\n");
//                msg.append("     ");
//                msg.append("Query Failure Error: ");
//                msg.append(errorCode);
//                msg.append("\n");
//                msg.append("     ");
//                msg.append("Remote Client Address: ");
//                msg.append(queryCompletedEvent.getContext().getRemoteClientAddress().toString());
//
//                logger.info(msg.toString());
//
//            }
//            else {
//
//                msg.append("---------------Query Completed----------------------------");
//                msg.append("\n");
//                msg.append("     ");
//                msg.append("Query ID: ");
//                msg.append(queryCompletedEvent.getMetadata().getQueryId().toString());
//                msg.append("\n");
//                msg.append("     ");
//                msg.append("Create Time: ");
//                msg.append(queryCompletedEvent.getCreateTime());
//                msg.append("\n");
//                msg.append("     ");
//                msg.append("User: ");
//                msg.append(queryCompletedEvent.getContext().getUser().toString());
//                msg.append("\n");
//                msg.append("     ");
//                msg.append("Complete: ");
//                msg.append(queryCompletedEvent.getStatistics().isComplete());
//                msg.append("\n");
//                msg.append("     ");
//                msg.append("Remote Client Address: ");
//                msg.append(queryCompletedEvent.getContext().getRemoteClientAddress().toString());
//
//                logger.info(msg.toString());
//            }
//        }
//        catch (Exception ex) {
//            logger.info(ex.getMessage());
//        }
    }

    public void splitCompleted(SplitCompletedEvent splitCompletedEvent) {
//        StringBuilder msg = new StringBuilder();
//
//        try {
//
//            msg.append("---------------Split Completed----------------------------");
//            msg.append("\n");
//            msg.append("     ");
//            msg.append("Query ID: ");
//            msg.append(splitCompletedEvent.getQueryId().toString());
//            msg.append("\n");
//            msg.append("     ");
//            msg.append("Stage ID: ");
//            msg.append(splitCompletedEvent.getStageId().toString());
//            msg.append("\n");
//            msg.append("     ");
//            msg.append("Task ID: ");
//            msg.append(splitCompletedEvent.getTaskId().toString());
//
//            logger.info(msg.toString());
//
//        }
//        catch (Exception ex) {
//            logger.info(ex.getMessage());
//        }

    }

//    public void createLogFile()
//    {
//
//        SimpleDateFormat dateTime = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
//        String timeStamp = dateTime.format(new Date());
//        StringBuilder logPath = new StringBuilder();
//
//        logPath.append("/var/log/presto/queries-");
//        logPath.append(timeStamp);
//        logPath.append(".%g.log");
//
//        try {
//            logger = Logger.getLogger(loggerName);
//            fh = new FileHandler(logPath.toString(), 524288000, 5, true);
//            logger.addHandler(fh);
//            logger.setUseParentHandlers(false);
//            SimpleFormatter formatter = new SimpleFormatter();
//            fh.setFormatter(formatter);
//        }
//        catch (IOException e) {
//            logger.info(e.getMessage());
//        }
//    }

}
