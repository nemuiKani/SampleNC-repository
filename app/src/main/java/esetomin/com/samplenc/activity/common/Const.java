package com.esetomin.simplealarm.common;

public class Const {

    /** パラメータ_キー_表示画面 */
    public static final String PARAM_KEY_DISP_SCREEN = "PARAM_KEY_DISP_SCREEN";
    /** パラメータ_バリュー_アラーム一覧 */
    public static final String PARAM_VALU_ALARM_DISP = "PARAM_VALU_ALARM_DISP";
    /** パラメータ_バリュー_アラームグループ */
    public static final String PARAM_VALU_ALARM_GROUP = "PARAM_VALU_ALARM_GROUP";
    /** パラメータ_バリュー_グループ設定 */
    public static final String PARAM_VALU_ALARM_SETTING = "PARAM_VALU_ALARM_SETTING";
    /** パラメータ_バリュー_アラーム設定 */
    public static final String PARAM_VALU_ALARM_GROUP_SETTING = "PARAM_VALU_ALARM_GROUP_SETTING";
    /** パラメータ_キー_アラームグループテーブルの項目保持モデル */
    public static final String PARAM_KEY_ALARM_MODEL = "PARAM_KEY_ALARM_MODEL";

    /** コマンド_SELECT * */
    public static final String CMD_SELECT_ALL = "SELECT * FROM ";
    /** コマンド_CREATE TABEL */
    public static final String CMD_CREATE_TABLE = "CREATE TABLE ";
    /** コマンド_DROP TABLE */
    public static final String CMD_DROP_TABLE = "DROP TABLE ";
    /** コマンド_INSERT INTO */
    public static final String CMD_INSERT_INTO = "INSERT INTO ";
    /** コマンド_DELETE FROM */
    public static final String CMD_DELETE_FROM = "DELETE FROM ";
    /** コマンド_UPDATE */
    public static final String CMD_UPDATE = "UPDATE ";
    /** コマンド_SET */
    public static final String CMD_SET = " SET ";
    /** コマンド_VALUES */
    public static final String CMD_DEFAULT = " DEFAULT ";
    /** コマンド_VALUES */
    public static final String CMD_VALUES = " VALUES";
    /** コマンド_PRIMARY KEY */
    public static final String CMD_PRIMARY_KEY = " PRIMARY KEY ";
    /** コマンド_ORDER BY */
    public static final String CMD_ORDER_BY = " ORDER BY ";
    /** コマンド_IF EXIT */
    public static final String CMD_IF_EXIT = " IF EXISTS ";
    /** コマンド_AND */
    public static final String CMD_AND = " AND ";
    /** コマンド_OR */
    public static final String CMD_OR = " OR ";
    /** コマンド_WHERE */
    public static final String CMD_WHERE = " WHERE ";
    /** コマンド_AUTOINCREMENT */
    public static final String CMD_AUTOINCREMENT = "AUTOINCREMENT";
    /** コマンド_GET_ROWID */
    public static final String CMD_GET_ROW_ID = "ROWID = last_insert_rowid();";
    /** コマンド_ROWID */
    public static final String CMD_ROW_ID = "ROWID";
    /** コマンド_SELECT_SERIAL_NO * */
    //public static final String CMD_SELECT_SERIAL_NO = "SELECT SERIAL_NO FROM ";
    public static final String CMD_SELECT_SERIAL_NO = "select LAST_INSERT_ROWID()";

    /** 属性_TEXT */
    public static final String TYPE_TEXT = " TEXT";
    /** 属性_INTEGER */
    public static final String TYPE_INTEGER = " INTEGER";

    /** データーベース名 */
    public static final String DATABASE_NAME = "SIMPLE_ALARM";

    /** テーブル名_ミュージックアイテム */
    public static final String TBL_NAME_T_MUSIC_ITEM = "T_MUSIC_ITEM";
    /** カラム名_曲名 */
    public static final String T_MUSIC_ID = "ID";
    /** カラム名_曲名 */
    public static final String T_MUSIC_SONG_NAME = "SONG_NAME";
    /** カラム名_パス */
    public static final String T_MUSIC_PATH = "PATH";

    /** テーブル名_アラームグループ */
    public static final String TBL_NAME_T_ALARM_GROUP = "T_ALARM_GROUP";
    /** カラム名_グループ名 */
    public static final String T_ALARM_GROUP_GROUP_NAME = "GROUP_NAME";
    /** カラム名_アラーム起動パターン0 */
    public static final String T_ALARM_GROUP_ALARM_PATTERN_0 = "ALARM_PATTERN_0";
    /** カラム名_アラーム起動パターン1 */
    public static final String T_ALARM_GROUP_ALARM_PATTERN_1 = "ALARM_PATTERN_1";
    /** カラム名_アラーム起動パターン2 */
    public static final String T_ALARM_GROUP_ALARM_PATTERN_2 = "ALARM_PATTERN_2";
    /** カラム名_アラーム起動パターン3 */
    public static final String T_ALARM_GROUP_ALARM_PATTERN_3 = "ALARM_PATTERN_3";
    /** カラム名_アラーム起動パターン4 */
    public static final String T_ALARM_GROUP_ALARM_PATTERN_4 = "ALARM_PATTERN_4";
    /** カラム名_アラーム起動パターン5 */
    public static final String T_ALARM_GROUP_ALARM_PATTERN_5 = "ALARM_PATTERN_5";
    /** カラム名_アラーム起動パターン6 */
    public static final String T_ALARM_GROUP_ALARM_PATTERN_6 = "ALARM_PATTERN_6";
    /** カラム名_アラーム起動パターン7 */
    public static final String T_ALARM_GROUP_ALARM_PATTERN_7 = "ALARM_PATTERN_7";
    /** カラム名_アラーム起動パターン8 */
    public static final String T_ALARM_GROUP_ALARM_PATTERN_8 = "ALARM_PATTERN_8";
    /** カラム名_アラーム起動パターン9 */
    public static final String T_ALARM_GROUP_ALARM_PATTERN_9 = "ALARM_PATTERN_9";

    /** テーブル名_アラーム情報 */
    public static final String TBL_NAME_T_ALARM_INFO= "T_ALARM_INFO";
    /** カラム名_起動時間 */
    public static final String T_ALARM_INFO_START_DATE = "START_DATE";
    /** カラム名_オンオフフラグ */
    public static final String T_ALARM_INFO_ON_OFF_FLG = "ON_OFF_FLG";
    /** カラム名_シリアル番号 */
    public static final String T_ALARM_INFO_SERIAL_NO = "SERIAL_NO";

    /** テーブル名_アラーム無効管理 */
    public static final String TBL_NAME_T_ALARM_DISABLE_MANAGE= "T_ALARM_DISABLE_MANAGE";
    /** カラム名_無効終了日時 */
    public static final String T_ALARM_INFO_DISABLE_START = "DISABLE_START";
    /** カラム名_無効開始日時 */
    public static final String T_ALARM_INFO_DISABLE_END = "DISABLE_END";
}
