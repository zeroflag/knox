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
package org.apache.hadoop.test.mock;

import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Queue;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class MockServlet extends HttpServlet {

  public Queue<MockInteraction> interactions;

  public MockServlet( Queue<MockInteraction> interactions ) {
    this.interactions = interactions;
  }

  @Override
  protected void service( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
    assertThat( "Mock servlet has no available interactions.", interactions.isEmpty(), is( false ) );
    MockInteraction interaction = interactions.remove();
    interaction.expect().match( request );
    interaction.respond().apply( response );
  }
}
