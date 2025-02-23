package co.edu.unipiloto.mymessenger;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;


public class RecieveMessageActivity extends AppCompatActivity {

    public static final String EXTRA_MESSAGE = "message";
    public ArrayList<String> histo = new ArrayList<>();

    @Override
    protected void onCreate(Bundle SavedInstanceState){
        super.onCreate(SavedInstanceState);
        setContentView(R.layout.activity_recieve_message);
        Intent intent = getIntent();
        ArrayList<String> chat = intent.getStringArrayListExtra(EXTRA_MESSAGE);
        if (chat != null) {
            histo = chat;
        }
        //String messageText = intent.getStringExtra(EXTRA_MESSAGE);
        TextView messageView = (TextView) findViewById(R.id.chatE);
        //messageView.setText("Propietario : " + chat);
        String chatHistory = "";
        for (String message : histo) {
            chatHistory += message + "\n";
        }
        messageView.setText(chatHistory);
    }

    public void onSendMessageE(View view){
        EditText messageView = (EditText) findViewById(R.id.messageE);
        String messageText = messageView.getText().toString();
        histo.add("     "+"Paseador : " + messageText);
        Intent intent = new Intent(this,CreateMessageActivity.class);
        intent.putStringArrayListExtra(RecieveMessageActivity.EXTRA_MESSAGE,histo);
        startActivity(intent);
    }
    public ArrayList<String> storeHistory(String message){
        histo.add(message);
        return histo;

    }
}
