import 'package:flutter/material.dart';

class Home extends StatefulWidget {
  @override
  _HomeState createState() => _HomeState();
}

class _HomeState extends State<Home> {

  @override
  Widget build(BuildContext context) {

    GlobalKey<ScaffoldState> _scaffoldKey = new GlobalKey();

    return Scaffold(
      key: _scaffoldKey,
      drawer: Drawer(
        child: ListView(
          padding: EdgeInsets.zero,
          children: <Widget>[
            DrawerHeader(
              child: Text('Drawer Header'),
              decoration: BoxDecoration(
                color: Colors.blue,
              ),
            )
          ],
        ),
      ),
      body: Column(
        children: <Widget>[
          Container(
            margin: EdgeInsets.only(top: 24.0),
            child: Padding(
              padding: EdgeInsets.all(8.0),
              child: Material(
                  borderRadius: BorderRadius.circular(8.0),
                  elevation: 3.0,
                  child: Padding(
                    padding: EdgeInsets.all(4.0),
                      child: Builder(builder: (context){
                        return Row(
                          children: <Widget>[
                            IconButton(
                              icon: Icon(Icons.menu),
                              onPressed: (){
                                Scaffold.of(context).openDrawer();
                              },
                            ),
                            Expanded(
                              child: TextFormField(
                                decoration: InputDecoration(
                                    border: InputBorder.none,
                                    suffixIcon: Icon(Icons.search)
                                ),
                                style: TextStyle(
                                  fontSize: 24.0,
                                  color: Colors.grey[400],
                                ),
                              ),
                            )
                          ],
                        );
                      })
                  )
              ),
            )
          )
        ],
      ),
    );
  }
}
