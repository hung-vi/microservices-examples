!/bin/sh

AMQ_HOME=/opt/activemq
cp $AMQ_HOME/conf/activemq.xml $AMQ_HOME/conf/activemq-run.xml

env
cat $AMQ_HOME/conf/activemq-run.xml

# Run ActiveMQ instance
sed -i "s/dataDirectory=\"\${activemq.data}\">/dataDirectory=\"\${activemq.data}\" schedulerSupport=\"$SCHEDULER_SUPPORT\">/g" $AMQ_HOME/conf/activemq-run.xml

$AMQ_HOME/bin/activemq console xbean:file:$AMQ_HOME/conf/activemq-run.xml
