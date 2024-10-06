package raisetech.StudentManagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StudentManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudentManagementApplication.class, args);
	}
}

//タスクの見積もり方
//・全体像を把握する or 目的が何なのか。
//・何をもって完了とするか。不明瞭なら必ず確認する。
//・事前条件の確認。
//・タスク分解。
//  コントローラーを作る、サービスを作る、リポジトリを作る、コンバーターを作る、データオブジェクトを作る、画面作る、テスト作成およびテスト実施。
//・一時間単位に分割する。1時間で終わるくらいの粒度に分割する。
//・タスク分解ができなければ、それはタスクの理解が低い。
//・理解するための調査タスクをタスクとして入れる必要がある。
//・見積もりをするための見積もりタスクが発生することはよくある。
//・理解度が浅い状態で出せる見積もりは出しておく。そのうえで調査して、新しい見積もりを作る。
//・見積もりをして実践して、見積もりが変わって……というのを繰り返していく。
//・見積もりと実践、予定と実績は必ず残しておく。
//・見積もりから比較的大きめの乖離があった場合は反省する。

//Trelloというツール、タスクボード。
//スマホの時間計測アプリ、タスク管理ツール。