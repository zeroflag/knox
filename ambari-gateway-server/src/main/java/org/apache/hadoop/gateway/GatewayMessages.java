/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.hadoop.gateway;

import org.apache.hadoop.gateway.i18n.messages.Message;
import org.apache.hadoop.gateway.i18n.messages.Messages;
import org.apache.hadoop.gateway.i18n.messages.StackTrace;

import static org.apache.hadoop.gateway.i18n.messages.MessageLevel.*;

/**
 *
 */
@Messages
public interface GatewayMessages {

  @Message(level=INFO, text="Starting gateway..." )
  void startingGateway();

  @Message(level=FATAL, text="Failed to start gateway: {0}" )
  void failedToStartGateway( @StackTrace(level=DEBUG) Exception e );

  @Message(level=INFO, text="Gateway started on port {0}." )
  void startedGateway( int port );
}
