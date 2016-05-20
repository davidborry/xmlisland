package main.test.datas.responses;

import main.java.datas.responses.Error;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Test;

/**
 * Created by david on 20/05/2016.
 */
public class ErrorTest {

    String s = "{\n" +
            "    \"exception\": [\"IllegalArgumentException\"],\n" +
            "    \"stacktrace\": [[\n" +
            "      \"scala.Predef$.require(Predef.scala:219)\",\n" +
            "      \"eu.ace_design.island.game.actions.Fly.buildResult(Fly.scala:24)\",\n" +
            "      \"eu.ace_design.island.game.Action$class.build(Actions.scala:39)\",\n" +
            "      \"eu.ace_design.island.game.Action$class.apply(Actions.scala:26)\",\n" +
            "      \"eu.ace_design.island.game.actions.Fly.apply(Fly.scala:5)\",\n" +
            "      \"eu.ace_design.island.game.Engine.process$1(Engine.scala:62)\",\n" +
            "      \"eu.ace_design.island.game.Engine.play(Engine.scala:83)\",\n" +
            "      \"eu.ace_design.island.game.Engine.run(Engine.scala:39)\",\n" +
            "      \"eu.ace_design.island.arena.Championship$class.silent(Championship.scala:90)\",\n" +
            "      \"Week02$.silent(Week02.scala:7)\",\n" +
            "      \"eu.ace_design.island.arena.Championship$class.handlePlayer(Championship.scala:71)\",\n" +
            "      \"Week02$.handlePlayer(Week02.scala:7)\",\n" +
            "      \"eu.ace_design.island.arena.Championship$$anonfun$run$1.apply(Championship.scala:61)\",\n" +
            "      \"eu.ace_design.island.arena.Championship$$anonfun$run$1.apply(Championship.scala:58)\",\n" +
            "      \"scala.collection.TraversableLike$$anonfun$map$1.apply(TraversableLike.scala:245)\",\n" +
            "      \"scala.collection.TraversableLike$$anonfun$map$1.apply(TraversableLike.scala:245)\",\n" +
            "      \"scala.collection.immutable.HashMap$HashMap1.foreach(HashMap.scala:221)\",\n" +
            "      \"scala.collection.immutable.HashMap$HashTrieMap.foreach(HashMap.scala:428)\",\n" +
            "      \"scala.collection.immutable.HashMap$HashTrieMap.foreach(HashMap.scala:428)\",\n" +
            "      \"scala.collection.TraversableLike$class.map(TraversableLike.scala:245)\",\n" +
            "      \"scala.collection.AbstractTraversable.map(Traversable.scala:104)\",\n" +
            "      \"eu.ace_design.island.arena.Championship$class.run(Championship.scala:58)\",\n" +
            "      \"Week02$.run(Week02.scala:7)\",\n" +
            "      \"eu.ace_design.island.arena.Run$class.run(Run.scala:47)\",\n" +
            "      \"Week02$.run(Week02.scala:7)\",\n" +
            "      \"Week02$.delayedEndpoint$Week02$1(Week02.scala:21)\",\n" +
            "      \"Week02$delayedInit$body.apply(Week02.scala:7)\",\n" +
            "      \"scala.Function0$class.apply$mcV$sp(Function0.scala:40)\",\n" +
            "      \"scala.runtime.AbstractFunction0.apply$mcV$sp(AbstractFunction0.scala:12)\",\n" +
            "      \"scala.App$$anonfun$main$1.apply(App.scala:76)\",\n" +
            "      \"scala.App$$anonfun$main$1.apply(App.scala:76)\",\n" +
            "      \"scala.collection.immutable.List.foreach(List.scala:381)\",\n" +
            "      \"scala.collection.generic.TraversableForwarder$class.foreach(TraversableForwarder.scala:35)\",\n" +
            "      \"scala.App$class.main(App.scala:76)\",\n" +
            "      \"Week02$.main(Week02.scala:7)\",\n" +
            "      \"Week02.main(Week02.scala)\",\n" +
            "      \"sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)\",\n" +
            "      \"sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)\",\n" +
            "      \"sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)\",\n" +
            "      \"java.lang.reflect.Method.invoke(Method.java:483)\",\n" +
            "      \"com.intellij.rt.execution.application.AppMain.main(AppMain.java:144)\"\n" +
            "    ]],\n" +
            "    \"message\": [\"requirement failed: Congrats, the plane is out of radio range...\"]\n" +
            "  }";

    JSONObject jsonObject;
    Error error;

    @Test
    public void errorTest(){
        try{
            jsonObject = new JSONObject(s);
            error = new Error(jsonObject);

            error.extractDatas();

            String[] exceptions = error.getExceptions();
            String[] messages = error.getMessages();
            String[][] stackTrace = error.getStackTrace();

            System.out.println(exceptions[0]);
            System.out.println(messages[0]);
            System.out.println(stackTrace[0][6]);
        }

        catch (JSONException e){
            e.printStackTrace();
        }
    }
}
