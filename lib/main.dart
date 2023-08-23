import 'package:flutter/material.dart';
import 'package:http/http.dart' as http;
import 'dart:convert';

void main() {
  runApp(MyApp());
}

class MyApp extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'HTTP Requests',
      theme: ThemeData(
        primarySwatch: Colors.blue,
      ),
      home: MyHomePage(),
    );
  }
}

class MyHomePage extends StatefulWidget {
  @override
  _MyHomePageState createState() => _MyHomePageState();
}

class _MyHomePageState extends State<MyHomePage> {
  final String url = "http://localhost:8118/api/counter";

  int valueFromGet = 0;

  void sendPostRequest() async {
    try {
      var response = await http.post(
        Uri.parse(url),
      );
      print("POST Request Response: ${response.statusCode}");
    } catch (error) {
      print("Error sending POST request: $error");
    }
  }

  void sendGetRequest() async {
    try {
      final response = await http.get(
        Uri.parse(url),
      );
      if (response.statusCode == 200) {
        Map<String, dynamic> responseData = jsonDecode(response.body);
        setState(() {
          valueFromGet = responseData['value'];
        });
        print("GET Request Response: $valueFromGet");
      } else {
        print("GET Request failed with status: ${response.statusCode}");
      }
    } catch (error) {
      print("Error sending GET request: $error");
    }
  }

  @override
  void initState() {
    super.initState();
    sendGetRequest();
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text("HTTP Requests"),
      ),
      body: Center(
        child: Column(
          mainAxisAlignment: MainAxisAlignment.center,
          children: <Widget>[
            ElevatedButton(
              onPressed: () {
                sendPostRequest();
              },
              child: Text("Send POST Request"),
            ),
            SizedBox(height: 20),
            Text("Value from GET Request: $valueFromGet"),
          ],
        ),
      ),
    );
  }
}
