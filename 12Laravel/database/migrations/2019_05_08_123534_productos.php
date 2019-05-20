<?php

use Illuminate\Support\Facades\Schema;
use Illuminate\Database\Schema\Blueprint;
use Illuminate\Database\Migrations\Migration;

class Productos extends Migration
{
    /**php
     * Run the migrations.
     *
     * @return void
     */
    public function up()
    {
        Schema::create('producto', function(Blueprint $table) {
            $table->increments('id');
            $table->string('name');
            $table->integer('cantidad');
            $table->decimal('precio');
            $table->unsignedInteger('id_proveedor');
            $table->unsignedInteger('id_categoria');
            $table->foreign('id_proveedor')->references('id')->on('proveedor');
            $table->foreign('id_categoria')->references('id')->on('categoria');
            $table->timestamps('');
        });
    }

    /**
     * Reverse the migrations.
     *
     * @return void
     */
    public function down()
    {
        //
    }
}
